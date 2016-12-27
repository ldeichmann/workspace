class Backend:
    def update_database(self):
        raise NotImplementedError("Should have implemented this")

    def get_all_albums(self):
        raise NotImplementedError("Should have implemented this")

    def get_albums_for_artist(self, artist):
        raise NotImplementedError("Should have implemented this")

    def search_database(self, value):
        raise NotImplementedError("Should have implemented this")

    def add_song(self, song):
        raise NotImplementedError("Should have implemented this")

    def remove_song(self, song):
        raise NotImplementedError("Should have implemented this")

    def get_song_uri(self, song):
        raise NotImplementedError("Should have implemented this")
