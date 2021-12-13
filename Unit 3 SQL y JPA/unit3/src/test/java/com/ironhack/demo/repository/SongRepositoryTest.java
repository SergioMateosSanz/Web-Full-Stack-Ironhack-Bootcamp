package com.ironhack.demo.repository;

import com.ironhack.demo.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongRepositoryTest {

    @Autowired
    private SongRepository songRepository;
    Song songOne;
    Song songTwo;

    @BeforeEach
    void setUp() {
        songOne = new Song("Title One", "Album One", "Artist One");
        songTwo = new Song("Title Two", "Album Two", "Artist Two");
        songRepository.save(songOne);
        songRepository.save(songTwo);
    }

    @AfterEach
    void tearDown() {
        songRepository.deleteAll();
    }

    @Test
    void test_JPAMethods() {
        List<Song> songList = songRepository.findAll();
        assertEquals(2, songList.size());

        Optional<Song> songLooked = songRepository.findById(songOne.getId());

        if (!songLooked.isPresent()) {
            fail("Not song found");
        }
        assertTrue(songLooked.isPresent());
        assertEquals(songOne, songLooked.get());

    }

    @Test
    void findByArtist_ReturnSongsList_ExistingArtist() {
        Optional<List<Song>> songDB = songRepository.findByArtist("Artist One");
        assertTrue(songDB.isPresent());
        assertEquals(songDB.get().get(0), songOne);
    }

    @Test
    void findByArtistLike_ReturnSongsList_ExistingArtists() {
        List<Song> songLike = songRepository.findByArtistLike("Artist%");
        assertEquals(2, songLike.size());
    }

    @Test
    void getAll_ExistingSongs() {
        List<Song> songList = songRepository.getAll();
        assertEquals(2, songList.size());
    }

    @Test
    void getAllTittles_CorrectExecution() {
        List<Object[]> tittles = songRepository.getAllTittles();
        assertEquals(2, tittles.size());
        assertEquals(tittles.get(0)[0], "Title One");
        assertEquals(tittles.get(1)[0], "Title Two");
    }

    @Test
    void getAllTittlesByArtist_CorrectExecution() {
        List<Object[]> tittles = songRepository.getAllTittlesByArtistContain("%One%");
        assertEquals(1, tittles.size());
        assertEquals(tittles.get(0)[0], "Title One");
    }

    @Test
    void getAllTittlesByArtistContainNative_CorrectExecution() {
        List<Object[]> tittles = songRepository.getAllTittlesByArtistContainNative("%One%");
        assertEquals(1, tittles.size());
        assertEquals(tittles.get(0)[0], "Title One");
    }
}