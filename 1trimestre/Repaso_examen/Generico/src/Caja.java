public class Caja<T> {
    private T e;
    public Caja(T e) {
        this.e = e;
    }
    public T getE() {
        return e;
    }
    public void setE(T e) {
        this.e = e;
    }
    @Override
    public String toString() {
        return "Caja{" + "elemento=" + e + '}';
    }
}
