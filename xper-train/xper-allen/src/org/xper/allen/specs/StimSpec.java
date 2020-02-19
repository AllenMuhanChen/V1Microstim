package org.xper.allen.specs;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class StimSpec {
	@XStreamAlias("targetEyeWinSize")
	float targetEyeWinSize;
	@XStreamAlias("stimObjData")
	long[] stimObjData;
	@XStreamAlias("eStimObjData")
	long[] eStimObjData;
	@XStreamAlias("eStimObjChans")
	int[] eStimObjChans;
	
	public StimSpec(long[] stimObjIds, long[] estimIds) {
		stimObjIds = new long[stimObjIds.length];
		estimIds = new long[estimIds.length];
	}
	
	public StimSpec() {
	//Default Constructor	
	}
	transient static XStream s;
	
	static {
		s = new XStream();
		s.alias("StimSpec", StimSpec.class);
	}
	
	public static String toXml (StimSpec spec) {
		return s.toXML(spec);
	}
	
	public String toXml() {
		return StimSpec.toXml(this);
	}
	
	public static StimSpec fromXml (String xml) {
		
		//s.aliasField("targetEyeWinSize", StimSpec.class, "targetEyeWinSize");
		StimSpec ss = (StimSpec)s.fromXML(xml);
		return ss;
	}

	public long[] getStimObjData() {
		return stimObjData;
	}

	public void setStimObjData(long[] stimObjData) {
		this.stimObjData = stimObjData;
	}

	public long[] geteStimObjData() {
		return eStimObjData;
	}

	public void seteStimObjData(long[] eStimObjData) {
		this.eStimObjData = eStimObjData;
	}

	public int[] geteStimObjChans() {
		return eStimObjChans;
	}

	public void seteStimObjChans(int[] eStimObjChans) {
		this.eStimObjChans = eStimObjChans;
	}

	public float getTargetEyeWinSize() {
		return targetEyeWinSize;
	}

	public void setTargetEyeWinSize(float targetEyeWinSize) {
		this.targetEyeWinSize = targetEyeWinSize;
	}

}
