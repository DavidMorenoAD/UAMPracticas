/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
Aqui estan todos los atributos de la clase Coach donde se insertaran posteriormente de la hoja de extencion csv
 */
public class Coach implements Comparable<Coach>{

	private String CoachId;
	private String year;
	private String tmID;
        private String lgID;
        private String stint;
        private String won;
        private String lost;
        private String post_wins;
        private String post_lossses;       
        
// Getter y Setters
        
    public String getCoachId() {
        return CoachId;
    }

    public void setCoachId(String CoachId) {
        this.CoachId = CoachId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTmID() {
        return tmID;
    }

    public void setTmID(String tmID) {
        this.tmID = tmID;
    }

    public String getLgID() {
        return lgID;
    }

    public void setLgID(String lgID) {
        this.lgID = lgID;
    }

    public String getStint() {
        return stint;
    }

    public void setStint(String stint) {
        this.stint = stint;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getPost_wins() {
        return post_wins;
    }

    public void setPost_wins(String post_wins) {
        this.post_wins = post_wins;
    }

    public String getPost_lossses() {
        return post_lossses;
    }

    public void setPost_lossses(String post_lossses) {
        this.post_lossses = post_lossses;
    }



	@Override
	public String toString(){
		return "\nCoachID = "+getCoachId()+" -  Year = "+getYear()+" - TmID = "+getTmID()+" - LgID = "+getLgID() + " - Stint = " + getStint() +" - Won = " + getWon()+" - Lost = "+ getLost()+" - Post Wins = "+getPost_wins()+" - Post Losses = "+ getPost_lossses();
	}

    @Override
    public int compareTo(Coach o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        

}
