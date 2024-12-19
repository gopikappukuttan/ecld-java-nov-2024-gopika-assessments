import java.util.*;

class Track {
    private Long trackId;
    private String title;
    private int rating;
    private boolean isPremium;

    public Track(Long trackId, String title, int rating, boolean isPremium) {
        this.trackId = trackId;
        this.title = title;
        this.rating = rating;
        this.isPremium = isPremium;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}


interface PlaylistManager {
    void addTrack(Track track);

    void removeTrack(Long trackId);

    void moveTrack(int fromIndex, int toIndex);

    Iterator<Track> shuffleIterator();

    void updateRating(Long trackId, Integer newRating);
}

class SmartPlaylist implements PlaylistManager {
    private List<Track> currentQueue;
    private List<Track> playedTracks;

    public SmartPlaylist() {
        currentQueue = new ArrayList<>();
        playedTracks = new LinkedList<>();
    }

    public List<Track> getCurrentQueue() {
        return currentQueue;
    }

    public void setCurrentQueue(List<Track> currentQueue) {
        this.currentQueue = currentQueue;
    }

    public List<Track> getPlayedTracks() {
        return playedTracks;
    }

    public void setPlayedTracks(List<Track> playedTracks) {
        this.playedTracks = playedTracks;
    }

    @Override
    public void addTrack(Track track) {
        if (track == null) {
            throw new IllegalArgumentException("Track cannot be null.");
        }
        currentQueue.add(track);
    }

    @Override
    public void removeTrack(Long trackId) {
        boolean trackFound = false;
        Iterator<Track> iterator = currentQueue.iterator();
        while (iterator.hasNext()) {
            Track track = iterator.next();
            if (track.getTrackId().equals(trackId)) {
                iterator.remove();
                break;
            }
        }
        if (!trackFound) {
            throw new NoSuchElementException("Track with ID " + trackId + " not found.");
        }
    }

    @Override
    public void moveTrack(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= currentQueue.size() || toIndex < 0 || toIndex > currentQueue.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Track track = currentQueue.remove(fromIndex);
        currentQueue.add(toIndex, track);
    }

    @Override
    public Iterator<Track> shuffleIterator() {
        if (currentQueue.isEmpty()) {
            System.out.println("The playlist is empty. Shuffle not possible.");
            return Collections.emptyIterator();
        }
        List<Track> shuffledList = new ArrayList<>(currentQueue);
        Collections.shuffle(shuffledList);
        return shuffledList.iterator();
    }


    @Override
    public void updateRating(Long trackId, Integer newRating) {
        boolean trackFound = false;
        if (newRating == null || newRating < 1 || newRating > 5) {
            throw new IllegalArgumentException("Rating should be between 1 and 5.");
        }
        for (Track track : currentQueue) {
            if (track.getTrackId().equals(trackId)) {
                track.setRating(newRating);
                return;
            }
        }
        if (!trackFound) {
            throw new NoSuchElementException("Track with ID " + trackId + " not found.");
        }
    }

    public List<Track> getPremiumTracks() {
        List<Track> premiumTracks = new ArrayList<>();
        for (Track track : currentQueue) {
            if (track.isPremium()) {
                premiumTracks.add(track);
            }
        }
        return premiumTracks;
    }
}

public class SmartPlaylistManagementSystem {
    public static void main(String[] args) {
        try {
            SmartPlaylist playlist = new SmartPlaylist();

            playlist.addTrack(new Track(1L, "Malayalam", 4, true));
            playlist.addTrack(new Track(2L, "English", 5, false));
            playlist.addTrack(new Track(3L, "Hindi", 3, true));

            //Print Original Playlist
            System.out.println("Original Playlist:");
            printTracks(playlist.getCurrentQueue().iterator()); // Original order

            // Print the shuffled playlist
            System.out.println("\nShuffled Playlist:");
            Iterator<Track> shuffledIterator = playlist.shuffleIterator();
            printTracks(shuffledIterator);

            // Print premium tracks first
            System.out.println("\nPremium Tracks:");
            printTracks(playlist.getPremiumTracks().iterator());

            // Using updateRating method
            playlist.updateRating(1L, 5);
            System.out.println("\nUpdated Rating for Track 1:");
            printTracks(playlist.getCurrentQueue().iterator());

            // Using moveTrack() method
            playlist.moveTrack(0, 2);
            System.out.println("\nPlaylist After Moving Track:");
            printTracks(playlist.getCurrentQueue().iterator());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void printTracks(Iterator<Track> iterator) {
        while (iterator.hasNext()) {
            Track track = iterator.next();
            System.out.println("Track ID=" + track.getTrackId() +
                    ", Title=" + track.getTitle() +
                    ", Rating=" + track.getRating() +
                    ", Premium=" + track.isPremium());
        }
    }
}


