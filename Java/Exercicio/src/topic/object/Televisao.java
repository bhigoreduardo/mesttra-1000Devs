package topic.object;

public class Televisao {

	private int volumeAtual;
	private int canalAtual;

	public Televisao(int volumeAtual, int canalAtual) {
		this.volumeAtual = volumeAtual;
		this.canalAtual = canalAtual;
	}

	public int getVolumeAtual() {
		return this.volumeAtual;
	}

	public int getCanalAtual() {
		return this.canalAtual;
	}

	public void setVolumeAtual(int volumeAtual) {
		this.volumeAtual = volumeAtual;
	}

	public void setCanalAtual(int canalAtual) {
		this.canalAtual = canalAtual;
	}

}