package aroa.proyecto.tienda.model;

    public class Skin {

        private int idSkin;
        private String idCategoria;
        private String nombre;
        private int precio;
        private String descripcion;
        private String imagenURL;


        public int getIdSkin() {
            return idSkin;
        }

        public void setIdSkin(int idSkin) {
            this.idSkin = idSkin;
        }

        public String getIdCategoria() {
            return idCategoria;
        }

        public void setIdCategoria(String idCategoria) {
            this.idCategoria = idCategoria;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getImagenURL() {
            return imagenURL;
        }

        public void setImagenURL(String imagenURL) {
            this.imagenURL = imagenURL;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Skin)) return false;
            Skin skin = (Skin) o;
            return getIdSkin() == skin.getIdSkin();
        }
}

