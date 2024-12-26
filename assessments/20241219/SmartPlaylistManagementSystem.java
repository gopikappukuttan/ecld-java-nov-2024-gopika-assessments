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

    public SmartPlaylist() {
        currentQueue = new ArrayList<>();
    }

    public List<Track> getCurrentQueue() {
        return currentQueue;
    }

    /**
     * Justification for using ArrayList:
     * - Frequent access by index is required for operations like moving tracks, which is efficient in ArrayList.
     * - ArrayList provides better performance compared to LinkedList for scenarios with fewer insertions/deletions in the middle.
     */

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
                trackFound = true;
                break;
            }
        }
        if (!trackFound) {
            System.err.println("Track with ID " + trackId + " not found in the playlist.");
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
                trackFound = true;
                break;
            }
        }
        if (!trackFound) {
            System.err.println("Track with ID " + trackId + " not found.");
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
        Scanner scanner = new Scanner(System.in);
        SmartPlaylist playlist = new SmartPlaylist();

        while (true) {
            System.out.println("\n--- Smart Playlist Management System ---");
            System.out.println("1. Add Track");
            System.out.println("2. Remove Track");
            System.out.println("3. Move Track");
            System.out.println("4. Shuffle Playlist");
            System.out.println("5. Update Track Rating");
            System.out.println("6. View Premium Tracks");
            System.out.println("7. View All Tracks");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Track ID: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Rating (1-5): ");
                    int rating = scanner.nextInt();
                    System.out.print("Is Premium (true/false): ");
                    boolean isPremium = scanner.nextBoolean();

                    playlist.addTrack(new Track(id, title, rating, isPremium));
                    System.out.println("Track added successfully.");
                }
                case 2 -> {
                    System.out.print("Enter Track ID to Remove: ");
                    Long id = scanner.nextLong();
                    playlist.removeTrack(id);
                }
                case 3 -> {
                    System.out.print("Enter From Index: ");
                    int fromIndex = scanner.nextInt();
                    System.out.print("Enter To Index: ");
                    int toIndex = scanner.nextInt();
                    try {
                        playlist.moveTrack(fromIndex, toIndex);
                        System.out.println("Track moved successfully.");
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Shuffled Playlist:");
                    printTracks(playlist.shuffleIterator());
                }
                case 5 -> {
                    System.out.print("Enter Track ID to Update Rating: ");
                    Long id = scanner.nextLong();
                    System.out.print("Enter New Rating (1-5): ");
                    int rating = scanner.nextInt();
                    try {
                        playlist.updateRating(id, rating);
                        System.out.println("Rating updated successfully.");
                    } catch (IllegalArgumentException | NoSuchElementException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("Premium Tracks:");
                    printTracks(playlist.getPremiumTracks().iterator());
                }
                case 7 -> {
                    System.out.println("All Tracks:");
                    printTracks(playlist.getCurrentQueue().iterator());
                }
                case 8 -> {
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printTracks(Iterator<Track> iterator) {
        if (!iterator.hasNext()) {
            System.out.println("No tracks to display.");
            return;
        }
        while (iterator.hasNext()) {
            Track track = iterator.next();
            System.out.println("Track ID=" + track.getTrackId() +
                    ", Title=" + track.getTitle() +
                    ", Rating=" + track.getRating() +
                    ", Premium=" + track.isPremium());
        }
    }
}
