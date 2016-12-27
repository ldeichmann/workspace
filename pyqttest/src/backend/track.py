class Track:
    id = None
    title = None
    artist = None
    album_artist = None
    album = None
    artist_id = None
    album_id = None
    track_no = None
    disc_no = None
    duration = None
    art = None

    def get_song_uri(self):
        raise NotImplementedError("Should have implemented this")
