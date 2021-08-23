package jvm.pablohdz.tweetapp.user;

public interface UserService {
    /**
     * Stores a user in the database
     *
     * @param user An {@link User} object.
     * @return the user stored in the database.
     */
    User addUser(User user);
}
