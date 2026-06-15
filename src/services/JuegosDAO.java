package services;

import model.JuegosModel;

import java.util.List;

public interface JuegosDAO {
    public void InsertJuego();
    public List<JuegosModel> GetJuegos();
    public void DeleteJuego();
    public void UpdateJuego();
}
