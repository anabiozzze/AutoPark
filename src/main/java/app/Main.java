package app;

import app.models.Auto;
import app.models.User;

public class Main {

    public static void main(String[] args) {
        // создадим сервис для передачи данных в дао и далее в БД
        UserService service = new UserService();
        User user = new User("Katya", 28);

        // добавим нового пользователя в БД
        service.createUser(user);

        // создадим несколько авто и присвоим их пользователю
        Auto jeep = new Auto("Wrangler", 107, "red");
        Auto ford = new Auto("Focus", 481, "grey");

        jeep.setUser(user);
        user.setAuto(jeep);

        ford.setUser(user);
        user.setAuto(ford);

        // обновим данные пользователя в БД
        service.updateUser(user);
    }
}
