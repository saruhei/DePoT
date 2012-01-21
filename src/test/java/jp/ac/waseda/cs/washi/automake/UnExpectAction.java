package jp.ac.waseda.cs.washi.automake;

public interface UnExpectAction<Tpage, Tpage2> {
	public <T> Tpage unExpectAct(Tpage2 page) throws ClassNotFoundException;

}
