/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.Autobus;

/**
 *
 * @author NURY
 */
public class Autobus {
    
    //Inserte acá los atributos
    private String nombreConductor;
    private int nPasajeros;
    private double cantidadDinero;
    private int nMaximoPasajeros;
    private double localizacionX;
    private double localizacionY;
    private boolean puertaAbierta;
    private boolean aireAcondicionadoActivado;
    private boolean motorEncendido;
    private boolean wifiEncendido;
    private boolean enMarcha;
    
    
    
    //Inserte acá el método constructor
    public Autobus(String nombreConductor, int nMaximoPasajeros, boolean puertaAbierta){
        this.nombreConductor = nombreConductor;
        this.nMaximoPasajeros = nMaximoPasajeros;
        this.puertaAbierta = puertaAbierta;
    }
    
   //Inserte acá los métodos (NO LOS GETTER Y SETTERS)
    
    public void recogerPasajero(int estrato){
        int numPas = getnPasajeros();
        int maxPas = getnMaximoPasajeros();
        if( !(isEnMarcha()) && isPuertaAbierta() && (numPas < maxPas )){
            if(estrato == 0 || estrato == 1 || estrato == 2){
                double dinTotal = getCantidadDinero();
                dinTotal = dinTotal + 1500;
                setCantidadDinero(dinTotal);
                int numPasajeros = getnPasajeros();
                numPasajeros = numPasajeros + 1;
                setnPasajeros(numPasajeros);
            }else if(estrato == 3 || estrato == 4){
                double dinTotal = getCantidadDinero();
                dinTotal = dinTotal + 2600;
                setCantidadDinero(dinTotal);
                int numPasajeros = getnPasajeros();
                numPasajeros = numPasajeros + 1;
                setnPasajeros(numPasajeros);
            }else if(estrato == 5 || estrato == 6 ){
                double dinTotal = getCantidadDinero();
                dinTotal = dinTotal + 3000;
                setCantidadDinero(dinTotal);
                int numPasajeros = getnPasajeros();
                numPasajeros = numPasajeros + 1;
                setnPasajeros(numPasajeros);
            }
        }
        
    }
    
    
    public void dejarPasajero(){
        
        int numPass = getnPasajeros();
        if(!(isEnMarcha()) && (isPuertaAbierta()) && (numPass > 0)){
            int n = getnPasajeros();
            n = n - 1;
            setnPasajeros(n);
        }
    }
    
    
    public double calcularDistanciaAcopio(){
        double posX = getLocalizacionX();
        double posY = getLocalizacionY();
        
        double distancia = Math.sqrt((Math.pow(posX, 2)) + (Math.pow(posY, 2)));
        return distancia;
    }
    
    
    public void gestionarPuerta(){
       
        if(!(isEnMarcha())){
            this.puertaAbierta = !this.puertaAbierta;
        }
    }
    
    
    public void gestionarAireAcondicionado(){
        if(isMotorEncendido()){
            if(isAireAcondicionadoActivado()){
                setAireAcondicionadoActivado(false);
            } else {
                setAireAcondicionadoActivado(true);
            }
        } else {
            setAireAcondicionadoActivado(false);
        }
    }
    
    
    public void gestionarMotor(){
        if(isMotorEncendido()){
            setMotorEncendido(false);
            setAireAcondicionadoActivado(false);
            setWifiEncendido(false);
        } else {
            setMotorEncendido(true);
        }
    }
    
    
    public void gestionarWifi(){
        if(isMotorEncendido()){
            if(isWifiEncendido()){
                setWifiEncendido(false);
            } else {
                setWifiEncendido(true);
            }
        } else {
            setWifiEncendido(false);
        }
    }
    
    
    public void gestionarMarcha(){
        if(isMotorEncendido() && !(isPuertaAbierta())){
            if(isEnMarcha()){
                setEnMarcha(false);
            } else {
                setEnMarcha(true);
            }
        }
    }
    
    
    public void moverDerecha(double d){
        double pos = getLocalizacionX();
        if(isEnMarcha()){
            double posf = pos + d;
            setLocalizacionX(posf);
        } else {
            setLocalizacionX(pos);
        }
    }
    
    
    public void moverIzquierda(double d){
        double pos = getLocalizacionX();
        if(isEnMarcha()){
            double posf = pos - d;
            setLocalizacionX(posf);
        } else {
            setLocalizacionX(pos);
        }
    }
    
    
    public void moverArriba(double d){
        double pos = getLocalizacionY();
        if(isEnMarcha()){
            double posf = pos + d;
            setLocalizacionY(posf);
        } else {
            setLocalizacionY(pos);
        }
    }
    
    
    public void moverAbajo(double d){
        double pos = getLocalizacionY();
        if(isEnMarcha()){
            double posf = pos - d;
            setLocalizacionY(posf);
        } else {
            setLocalizacionY(pos);
        }
    }
    
    
   //Inserte acá los SETTERS Y GETTERS
    public String getNombreConductor(){
        return nombreConductor;
    }
    
    
    public void setNombreConductor(String nombreConductor){
        this.nombreConductor = nombreConductor;
    }
    
    
    public int getnPasajeros(){
        return nPasajeros;
    }
    
    
    public void setnPasajeros(int nPasajeros){
        this.nPasajeros = nPasajeros;
    }
    
    
    public double getCantidadDinero(){
        return cantidadDinero;
    }
    
    
    public void setCantidadDinero(double cantidadDinero){
        this.cantidadDinero = cantidadDinero;
    }
    
    
    public int getnMaximoPasajeros(){
        return nMaximoPasajeros;
    }
    
    
    public void setnMaximoPasajeros(int nMaximoPasajeros){
        this.nMaximoPasajeros = nMaximoPasajeros;
    }
    
    
    public double getLocalizacionX(){
        return localizacionX;
    }
    
    
    public void setLocalizacionX(double localizacionX){
        this.localizacionX = localizacionX;
    }
    
    
    public double getLocalizacionY(){
        return localizacionY;
    }
    
    
    public void setLocalizacionY(double localizacionY){
        this.localizacionY = localizacionY;
    }
    
    
    public boolean isPuertaAbierta(){
        return puertaAbierta;
    }
    
    
    public void setPuertaAbierta(boolean puertaAbierta){
        this.puertaAbierta = puertaAbierta;
    }
    
    
    public boolean isAireAcondicionadoActivado(){
        return aireAcondicionadoActivado;
    }
    
    
    public void setAireAcondicionadoActivado(boolean aireAcondicionadoActivado){
        this.aireAcondicionadoActivado = aireAcondicionadoActivado;
    }
    
    
    public boolean isMotorEncendido(){
        return motorEncendido;
    }
    
    
    public void setMotorEncendido(boolean motorEncendido){
        this.motorEncendido = motorEncendido;
    }
    
    
    public boolean isWifiEncendido(){
        return wifiEncendido;
    }
    
    
    public void setWifiEncendido(boolean wifiEncendido){
        this.wifiEncendido = wifiEncendido;
    }
    
    
    public boolean isEnMarcha(){
        return enMarcha;
    }
    
    
    public void setEnMarcha(boolean enMarcha){
        this.enMarcha = enMarcha;
    }
}