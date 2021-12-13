package com.ironhack.demo.repository;

import com.ironhack.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<List<Song>> findByArtist(String artist);

    List<Song> findByArtistLike(String artist);

    //JPQL
    @Query("SELECT s FROM Song AS s")
    List<Song> getAll();

    @Query("SELECT s.title FROM Song AS s")
    List<Object[]> getAllTittles();

    @Query("SELECT s.title FROM Song AS s WHERE s.artist LIKE :artist")
    List<Object[]> getAllTittlesByArtistContain(@Param("artist") String artist);

    //Query Native
    @Query(value = "SELECT song_title FROM song_table WHERE artist LIKE :artist", nativeQuery = true)
    List<Object[]> getAllTittlesByArtistContainNative(@Param("artist") String artist);
}
