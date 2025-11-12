package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Helper {
    Dotenv dotenv;
    public Helper(){
        this.dotenv = Dotenv.load();
    }
}
