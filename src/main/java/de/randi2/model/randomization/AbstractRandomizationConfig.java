package de.randi2.model.randomization;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import de.randi2.model.AbstractDomainObject;
import de.randi2.model.Trial;
import de.randi2.randomization.RandomizationAlgorithm;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "RandomizationConfig")
@EqualsAndHashCode(callSuper=true)
@ToString
public abstract class AbstractRandomizationConfig extends AbstractDomainObject {

	private static final long serialVersionUID = -942332706403245140L;
	@OneToOne
	@Getter 
	private Trial trial;
	@Transient
	private RandomizationAlgorithm<? extends AbstractRandomizationConfig> algorithm;

	public final RandomizationAlgorithm<? extends AbstractRandomizationConfig> getAlgorithm() {
		if (algorithm == null) {
			algorithm = createAlgorithm();
		}
		return algorithm;
	}

	public abstract RandomizationAlgorithm<? extends AbstractRandomizationConfig> createAlgorithm();


	public void setTrial(Trial _trial) {
		this.trial = _trial;
		if (trial.getRandomizationConfiguration() == null) {
			trial.setRandomizationConfiguration(this);
		}
	}
}
