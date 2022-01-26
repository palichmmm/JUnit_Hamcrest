public enum Group {
    WORK ("Работа"),
    FRIENDS ("Друзья"),
    FAMILY ("Семья");

    private String title;

    Group(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
