package bts;

public class Album {
    private int id;
    private String titulo;
    private String artista;
    private int anoLancamento;

    public Album() {}

    public Album(int id, String titulo, String artista, int anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
    }

    public Album(String titulo, String artista, int anoLancamento) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    public int getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

    @Override
    public String toString() {
        return "Album [id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", ano=" + anoLancamento + "]";
    }
}
