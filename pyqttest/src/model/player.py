import threading
import time
import gi
gi.require_version("Gst", "1.0")
from gi.repository import Gst, GObject
from src.model.playlist import Playlist
import src.backend.local as local

class Player:

    duration = None
    state = None
    playlist = None

    def __init__(self):
        Gst.init(None)
        g_loop = threading.Thread(target=GObject.MainLoop().run)
        g_loop.daemon = True
        g_loop.start()
        self.duration = Gst.CLOCK_TIME_NONE
        self.state = Gst.State.NULL
        self.playlist = Playlist()

        self.player = Gst.ElementFactory.make("playbin", "playbin")
        fake_sink = Gst.ElementFactory.make("fakesink", "fakesink")
        self.player.set_property("video-sink", fake_sink)

        bus = self.player.get_bus()
        bus.add_signal_watch()
        bus.connect("message", self.on_message)

    def get_state(self):
        return self.state

    def start_playback(self):
        curr = self.playlist.get_current_track()
        if not curr:
            self.playlist.next_track()
            curr = self.playlist.get_current_track()
        if curr:
            self.set_song(curr.get_song_uri())
            self.play()

    def play(self):
        self.player.set_state(Gst.State.PLAYING)
        self.get_duration()

    def pause(self):
        self.player.set_state(Gst.State.PAUSED)

    def stop(self):
        self.player.set_state(Gst.State.READY)
        self.player.set_property("uri", "")

    def next(self):
        self.playlist.next_track()
        curr = self.playlist.get_current_track()
        if not curr:
            self.stop()
        else:
            self.set_song(curr.get_song_uri())
            if self.state == Gst.State.PLAYING:
                self.play()

    def set_song(self, song):
        self.player.set_property("uri", song)

    def on_message(self, bus, message):
        t = message.type
        if t == Gst.MessageType.EOS:
            print("Playback finished")
            self.player.set_state(Gst.State.READY)
            self.next()
        elif t == Gst.MessageType.ERROR:
            err, debug = message.parse_error()
            print("Playback error")
            print(err)
            print(debug)
        elif t == Gst.MessageType.STATE_CHANGED:
            old, new, pending = message.parse_state_changed()
            self.state = new
            if new == Gst.State.READY or new == Gst.State.NULL:
                self.duration = Gst.CLOCK_TIME_NONE
            elif new == Gst.State.PLAYING:
                self.get_duration()

    def get_duration(self):
        if self.duration == Gst.CLOCK_TIME_NONE:
            ret, self.duration = self.player.query_duration(Gst.Format.TIME)
            if not ret:
                print("ERROR: Could not query current duration")

    def get_position(self):
        self.get_duration()
        ret, current = self.player.query_position(Gst.Format.TIME)
        return current / Gst.SECOND

if __name__ == '__main__':
    p = Player()
    p.playlist.add_songs_to_playlist(local.create_dummy_songs())
    p.start_playback()
    i = 0
    while True:
        time.sleep(5)
        print("{0}/{1} {2}".format(p.get_position(), (p.duration / Gst.SECOND), p.state))
        i += 5
