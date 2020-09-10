package br.com.cityconnect.integrador_sa_transportes.testes;

import java.util.Observable;
import java.util.Observer;

import br.com.cityconnect.integrador_sa_transportes.controller.CorVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.MainController;
import br.com.cityconnect.integrador_sa_transportes.dao.CorVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;
import br.com.cityconnect.integrador_sa_transportes.view.ControleJFrame;
import br.com.cityconnect.integrador_sa_transportes.view.PropertiesJFrame;

public class Teste2 implements Observer{
	
	public static void main(String args[]) throws Exception {
		
		//PropertiesUtil pu = new PropertiesUtil();
		
		//System.out.println((2F/13F)*100);
		
		//new PropertiesJFrame();

		//ObservableDemo observable = new ObservableDemo(null);
		
		CorVeiculoDAO d = new CorVeiculoDAO();
		
		System.out.println(d.findAllIDs().size());
		
		
	}

	private ObservableDemo weatherUpdate ;
	 
    @Override
    public void update(Observable observable, Object arg)
    {
    	MainController mainC = (MainController) observable;
    	
            System.out.println(mainC.getPosAtual()+"/"+mainC.getTotal());
            //System.out.println(arg);
    }
 

}

class ObservableDemo extends Observable
{
    private String weather;
 
    public ObservableDemo(String weather)
    {
            this.weather = weather;
    }
 
    public String getWeather()
    {
        return weather;
    }
 
    public void setWeather(String weather)
    {
        this.weather = weather;
        setChanged();
        notifyObservers();
    }
 
 
}