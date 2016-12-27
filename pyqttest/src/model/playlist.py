class Playlist:
    playlist = None
    position = None

    def __init__(self):
        self.playlist = []
        self.position = -1

    def callback_update(self):
        pass

    def add_songs_to_playlist(self, songs):
        for song in songs:
            self.add_song_to_playlist(song)

    def add_song_to_playlist(self, song, pos=None):
        # if there is a position and it is valid, insert at position
        if pos and len(self.playlist) > pos:
            self.playlist.insert(song, pos)
        else:
            self.playlist.append(song)

    def remove_from_playlist(self, pos):
        if len(self.playlist) > pos:
            self.playlist.remove(pos)

    def get_current_track(self):
        if self.position != -1 and self.position < len(self.playlist):
            return self.playlist[self.position]
        else:
            return None

    def next_track(self):
        if (self.position + 1) >= len(self.playlist):
            self.position = -1
        # if there is anything in the playlist
        elif len(self.playlist):
            self.position += 1
