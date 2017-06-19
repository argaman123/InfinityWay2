package Base;

public abstract class Slot {
    protected int[] emptys;
    protected int emptysAmount;
    public abstract void Show();
    public abstract int GetIndex(String name);
}
