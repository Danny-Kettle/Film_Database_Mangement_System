package wtp;

public class FilmDataControllerProxy implements wtp.FilmDataController {
  private String _endpoint = null;
  private wtp.FilmDataController filmDataController = null;
  
  public FilmDataControllerProxy() {
    _initFilmDataControllerProxy();
  }
  
  public FilmDataControllerProxy(String endpoint) {
    _endpoint = endpoint;
    _initFilmDataControllerProxy();
  }
  
  private void _initFilmDataControllerProxy() {
    try {
      filmDataController = (new wtp.FilmDataControllerServiceLocator()).getFilmDataController();
      if (filmDataController != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)filmDataController)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)filmDataController)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (filmDataController != null)
      ((javax.xml.rpc.Stub)filmDataController)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wtp.FilmDataController getFilmDataController() {
    if (filmDataController == null)
      _initFilmDataControllerProxy();
    return filmDataController;
  }
  
  public java.lang.String addFilmData(java.lang.String title, int year, java.lang.String director, java.lang.String stars, java.lang.String review) throws java.rmi.RemoteException{
    if (filmDataController == null)
      _initFilmDataControllerProxy();
    return filmDataController.addFilmData(title, year, director, stars, review);
  }
  
  public java.lang.String deleteFilmData(int id) throws java.rmi.RemoteException{
    if (filmDataController == null)
      _initFilmDataControllerProxy();
    return filmDataController.deleteFilmData(id);
  }
  
  public java.lang.String getAllFilmData(java.lang.String format) throws java.rmi.RemoteException{
    if (filmDataController == null)
      _initFilmDataControllerProxy();
    return filmDataController.getAllFilmData(format);
  }
  
  public java.lang.String searchFilmData(java.lang.String searchStr, java.lang.String format) throws java.rmi.RemoteException{
    if (filmDataController == null)
      _initFilmDataControllerProxy();
    return filmDataController.searchFilmData(searchStr, format);
  }
  
  public java.lang.String getFilmByID(java.lang.String format, int id) throws java.rmi.RemoteException{
    if (filmDataController == null)
      _initFilmDataControllerProxy();
    return filmDataController.getFilmByID(format, id);
  }
  
  public java.lang.String updateFilmData(int id, java.lang.String title, int year, java.lang.String director, java.lang.String stars, java.lang.String review) throws java.rmi.RemoteException{
    if (filmDataController == null)
      _initFilmDataControllerProxy();
    return filmDataController.updateFilmData(id, title, year, director, stars, review);
  }
  
  
}