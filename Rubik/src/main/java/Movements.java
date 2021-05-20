public enum Movements {
    U_CW(0),
    U_CCW(1),
    F_CW(2),
    F_CCW(3),
    R_CW(4),
    R_CCW(5),
    B_CW(6),
    B_CCW(7),
    D_CW(8),
    D_CCW(9),
    L_CW(10),
    L_CCW(11),
    ;

    int id;
    Movements(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Movements getMovement(int id) {
        if (id == this.id)
            return Movements.this;
        return null;
    }
}
