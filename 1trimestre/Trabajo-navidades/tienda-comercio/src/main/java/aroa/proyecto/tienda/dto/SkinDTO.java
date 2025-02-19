package aroa.proyecto.tienda.dto;

import aroa.proyecto.tienda.model.Skin;
import java.util.List;
import java.util.Optional;

public class SkinDTO extends Skin{

    private int numSkins;


    public SkinDTO(Skin skin, int numSkins) {
        this.setIdSkin(skin.getIdSkin());
        this.setNombre(skin.getNombre());
        this.setNumSkins(numSkins);
    }


    public int getNumSkins() {
        return numSkins;
    }
    public void setNumSkins(int numSkins) {
        this.numSkins = numSkins;
    }
}


