package topic.object;

public class Controle {

	private int volumeMaximo;
	private Televisao televisao;

	public Controle(int volumeMaximo) {
		this.volumeMaximo = volumeMaximo;
		this.televisao = new Televisao(0, 0);
	}

	public int diminuirVolume() {
		this.televisao.setVolumeAtual(this.televisao.getVolumeAtual() - 1);
		return this.televisao.getVolumeAtual();
	}

	public int aumentarVolume() {
		this.televisao.setVolumeAtual(this.televisao.getVolumeAtual() + 1);
		return this.televisao.getVolumeAtual();
	}

	public int diminuirCanal() {
		this.televisao.setCanalAtual(this.televisao.getCanalAtual() - 1);
		return this.televisao.getCanalAtual();
	}

	public int aumentarCanal() {
		this.televisao.setCanalAtual(this.televisao.getCanalAtual() + 1);
		return this.televisao.getCanalAtual();
	}

	public int mudarCanal(int canalAtual) {
		this.televisao.setCanalAtual(canalAtual);
		return this.televisao.getCanalAtual();
	}

	public void motrar() {
		System.out.println("Volume: " + this.televisao.getVolumeAtual());
		System.out.println("Canal: " + this.televisao.getCanalAtual());
	}
}