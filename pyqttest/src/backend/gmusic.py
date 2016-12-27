import asyncio
from gmusicapi import Mobileclient
from src.backend.backend import Backend
from src.backend.track import Track


class GmusicTrack(Track):
    def __init__(self, api, song_id, album_id, artist_id, title, album_artist, artist, album, track_no, disc_no, duration,
                 album_art_uri):
        self.api = api
        self.id = song_id
        self.title = title
        self.artist = artist
        self.album_artist = album_artist
        self.album = album
        self.artist_id = artist_id
        self.album_id = album_id
        self.track_no = track_no
        self.disc_no = disc_no
        self.duration = duration
        self.art = album_art_uri

    def get_song_uri(self):
        self.api.get_stream_url(self.id)


class GmusicAlbum:
    def __init__(self, album_id, artist_id, title, artist, album_art_uri):
        self.id = album_id
        self.title = title
        self.artist = artist
        self.artist_id = artist_id
        self.album_id = album_id
        self.art = album_art_uri
        self.songs = {}

    def add_song(self, song):
        if song.disc_no not in self.songs:
            self.songs[song.disc_no] = {}
        self.songs[song.disc_no][song.track_no] = song

    def remove_song(self, song_id):
        self.songs.pop(song_id, None)

    def get_songs(self):
        return self.songs


class GmusicPlaylist:
    def __init__(self, playlist_id, title, author, author_art_uri):
        self.id = playlist_id
        self.title = title
        self.author = author
        self.art = author_art_uri
        self.songs = {}

    def add_song(self, song):
        self.songs[len(self.songs)] = song

    def get_songs(self):
        return self.songs


class Gmusic(Backend):

    _songs = {}
    _albums = {}
    _artists = {}

    _username = None
    _password = None
    _device_id = None

    def __init__(self):
        self.api = Mobileclient()
        if not self._username or not self._password or not self._device_id:
            print("Could not automatically login, as login data is missing")
        else:
            if not self._login():
                print("Could not login")
            else:
                self.update_database()

    def _get_login(self):
        pass

    def _set_login(self, username, password, device_id):
        self._username = username
        self._password = password
        self._device_id = device_id

    def _login(self):
        return self.api.login(self._username, self._password, self._device_id)

    def remove_song(self, song_id):
        if song_id in self._songs:
            album_id = self._songs[song_id].album_id
            self._albums[album_id].remove_song(song_id)

    def update_database(self):
        loop = asyncio.get_event_loop()
        # Blocking call which returns when the hello_world() coroutine is done
        loop.run_until_complete(self._update_gmusic_songs())
        loop.close()

    def add_song(self, song_id):
        if song_id not in self._songs:
            self._parse_all_songs([song_id])

    def add_songs(self, ids):
        for song_id in ids:
            self.add_song(song_id)

    def get_albums_for_artist(self, artist):
        pass

    def get_all_albums(self):
        return self._albums

    def get_all_songs(self):
        return self._songs

    def search_database(self, value):
        pass

    async def _update_gmusic_songs(self):
        self._parse_all_songs(self.api.get_all_songs())
        pass

    def get_song_uri(self, song):
        return self.api.get_stream_url(song.id)

    def _parse_all_songs(self, songs):
        for song in songs:
            song_id = song.get("storeId", song.get("nid", 0))
            artist_id = song.get("artistId", [0])[0]
            album_id = song.get("albumId", 0)
            if song_id not in self._songs:
                title = song.get("title", "")
                album_name = song.get("album", "")
                duration = song.get("durationMillis", 0)
                album_art_uri = song.get("albumArtRef", [{"url":""}])[0].get("url", "")
                track_no = song.get("trackNumber", "0")
                disc_no = song.get("discNumber", "0")
                artist = song.get("artist", "")
                album_artist = song.get("albumArtist", artist)

                gsong = GmusicTrack(self.api, song_id, album_id, artist_id, title, album_artist, artist, album_name, track_no,
                                    disc_no, duration, album_art_uri)
            else:
                gsong = self._songs[song_id]

            if album_id in self._albums:
                album = self._albums[album_id]
            else:
                album = GmusicAlbum(album_id, artist_id, gsong.album, gsong.album_artist, gsong.art)
                self._albums[album_id] = album

            album.add_song(gsong)


if __name__ == '__main__':
    g = Gmusic()
    g._set_login("lukasdeichmann@gmail.com", "czgquwhugcmgyvce", "5303EB6EED73F60B")
    print(g._login())
    g.update_database()
    print(g.get_all_albums())
