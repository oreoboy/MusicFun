package controler;

import factories.LecteurFactory;
import ihm.IHMDessin;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;

import lecteur.LecteurDecore;

public class Controller implements ControllerEventListener{
	private LecteurDecore lecteurDecore;
	private IHMDessin ihmDessin;
	
	public Controller() { 
		try {
			this.lecteurDecore = new LecteurDecore(new LecteurFactory().getLecteur());
			this.ihmDessin = new IHMDessin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Controller(LecteurDecore lecteurDecore, IHMDessin ihmDessin) {
		this.lecteurDecore = lecteurDecore;
		this.ihmDessin = ihmDessin;
	}
	
	public void addControlEventListener() {		
		lecteurDecore.addControllerEventListener(this, null);
	}

	public LecteurDecore getLecteurDecore() {
		return lecteurDecore;
	}

	public void setLecteurDecore(LecteurDecore lecteurDecore) {
		this.lecteurDecore = lecteurDecore;
	}

	public IHMDessin getIhmDessin() {
		return ihmDessin;
	}

	public void setIhm(IHMDessin ihmDessin) {
		this.ihmDessin = ihmDessin;
	}

	@Override
	public void controlChange(ShortMessage event) {
		ihmDessin.setMsg(true);
		ihmDessin.repaint();
	}
}
