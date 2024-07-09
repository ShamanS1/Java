import java.util.Scanner;

class Movie {
    String title;
    int availableTickets;
    int bookedTickets;

    Movie(String title, int availableTickets) {
        this.title = title;
        this.availableTickets = availableTickets;
        this.bookedTickets = 0;
    }

    void bookTickets(int numberOfTickets) {
        if (numberOfTickets <= availableTickets) {
            availableTickets -= numberOfTickets;
            bookedTickets += numberOfTickets;
            System.out.println(numberOfTickets + " tickets booked for " + title + ".");
        } else {
            System.out.println("Not enough tickets available.");
        }
    }

    @Override
    public String toString() {
        return "Movie: " + title + " | Available Tickets: " + availableTickets + " | Booked Tickets: " + bookedTickets;
    }
}

public class MovieTicketBooking {
    private Movie[] movies;
    private int movieCount;
    private Scanner scanner = new Scanner(System.in);

    public MovieTicketBooking(int maxMovies) {
        movies = new Movie[maxMovies];
        movieCount = 0;
    }

    public static void main(String[] args) {
        MovieTicketBooking bookingSystem = new MovieTicketBooking(5); // max 5 movies
        bookingSystem.run();
    }

    private void run() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    bookTickets();
                    break;
                case 3:
                    displayMovies();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Movie Ticket Booking System");
        System.out.println("1. Add Movie");
        System.out.println("2. Book Tickets");
        System.out.println("3. Display Movies");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addMovie() {
        if (movieCount < movies.length) {
            System.out.print("Enter movie title: ");
            String title = scanner.nextLine();
            System.out.print("Enter number of available tickets: ");
            int availableTickets = scanner.nextInt();
            movies[movieCount++] = new Movie(title, availableTickets);
            System.out.println("Movie " + title + " added.");
        } else {
            System.out.println("Cannot add more movies. Maximum capacity reached.");
        }
    }

    private void bookTickets() {
        System.out.print("Enter movie title to book tickets for: ");
        String title = scanner.nextLine();
        Movie movie = findMovie(title);
        if (movie != null) {
            System.out.print("Enter number of tickets to book: ");
            int numberOfTickets = scanner.nextInt();
            movie.bookTickets(numberOfTickets);
        } else {
            System.out.println("Movie " + title + " not found.");
        }
    }

    private void displayMovies() {
        if (movieCount == 0) {
            System.out.println("No movies available.");
        } else {
            for (int i = 0; i < movieCount; i++) {
                System.out.println(movies[i]);
            }
        }
    }

    private Movie findMovie(String title) {
        for (int i = 0; i < movieCount; i++) {
            if (movies[i].title.equalsIgnoreCase(title)) {
                return movies[i];
            }
        }
        return null;
    }
}
