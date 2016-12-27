class LocalTrack:
    uri = None

    def __init__(self, uri, song_id, album_id, artist_id, title, album_artist, artist, album, track_no, disc_no,
                 duration, album_art_uri):
        self.uri = uri
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
        return "file://" + self.uri


def create_dummy_songs():
    songs = []
    songs.append(LocalTrack("/home/cru/Music/LTR/Subconscious/01 - LTR - Subconscious.mp3", 0, 0, 0, "", "", "", "", "",
                            "", "", ""))
    songs.append(LocalTrack("/home/cru/Music/ASD/Blockbasta/01 - ASD - Die Partei.mp3", 0, 0, 0, "", "", "", "", "",
                            "", "", ""))
    return songs