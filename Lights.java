package project3;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Shengwei Huang
 * 
 * This class represents the lights object
 */
public class Lights {
	private String name;
	private boolean isON;    
    private String opposite;    
    private String next;
    
    
    public static Map<String,Lights> map = new HashMap<String,Lights>(){{
    	put("SN",new Lights(false,"SN","NS","SW"));
    	put("SW",new Lights(false,"SW","NE","EW"));
    	put("EW",new Lights(false,"EW","WE","ES"));
    	put("ES",new Lights(false,"ES","WN","SN"));
    	put("NS",new Lights(false,"NS",null,null));
    	put("NE",new Lights(false,"NE",null,null));
    	put("WE",new Lights(false,"WE",null,null));
    	put("WN",new Lights(false,"WN",null,null));
    	put("SE",new Lights(true,"SE",null,null));
    	put("EN",new Lights(true,"EN",null,null));
    	put("NW",new Lights(true,"NW",null,null));
    	put("WS",new Lights(true,"WS",null,null));
    }};
 
    public Lights(boolean isOn,String name,String opposite,String next){
    	this.isON = isOn;
    	this.opposite = opposite;
    	this.next = next;
    	this.name = name;
    }
 
    /**
     * 
     * @return whether the light is on
     */
    public boolean isOn(){
    	return isON;
    }
    
    /**
     * light the lights
     */
    public void light(){    
        this.isON=true;          
        if(this.opposite!=null){    
            map.get(opposite).light();             
        }    
    }  
    
    /**
     * 
     * @param name the light's name
     * @return the lights having the name
     */
    public static Lights getByName(String name){
    	return map.get(name);
    }
    
    /**
     * change the light status
     * @return next light
     */
    public Lights change(){    
        this.isON=false;         
        if(opposite!=null){
            Lights.getByName(opposite).change();              
        }    
        Lights nextLight =null;    
        if(next!=null){
        	nextLight=Lights.getByName(next);    
        	nextLight.light();    
        }           
        return nextLight;    
    }    
}
