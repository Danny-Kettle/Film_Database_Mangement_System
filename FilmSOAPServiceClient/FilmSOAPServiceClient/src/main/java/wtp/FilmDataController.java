/**
 * FilmDataController.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wtp;

public interface FilmDataController extends java.rmi.Remote {
    public java.lang.String addFilmData(java.lang.String title, int year, java.lang.String director, java.lang.String stars, java.lang.String review) throws java.rmi.RemoteException;
    public java.lang.String deleteFilmData(int id) throws java.rmi.RemoteException;
    public java.lang.String getAllFilmData(java.lang.String format) throws java.rmi.RemoteException;
    public java.lang.String searchFilmData(java.lang.String searchStr, java.lang.String format) throws java.rmi.RemoteException;
    public java.lang.String getFilmByID(java.lang.String format, int id) throws java.rmi.RemoteException;
    public java.lang.String updateFilmData(int id, java.lang.String title, int year, java.lang.String director, java.lang.String stars, java.lang.String review) throws java.rmi.RemoteException;
}
