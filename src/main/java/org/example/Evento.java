package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipo_evento")
    private String tipoEvento;

    @Column(name = "numero_max_partecipanti")
    private int numPartecipanti;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partecipazione> partecipazioni;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Evento() {

    }

    public Evento(String title, LocalDate data, String descr, String eventType, int partecipanti) {
        this.titolo = title;
        this.dataEvento = data;
        this.descrizione = descr;
        this.tipoEvento = eventType;
        this.numPartecipanti = partecipanti;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String tit) {
        this.titolo = tit;
    }

    public LocalDate getDataEvento() {
        return this.dataEvento;
    }

    public void setDataEvento(LocalDate date) {
        this.dataEvento = date;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descr) {
        this.descrizione = descr;
    }

    public String getTipoEvento() {
        return this.tipoEvento;
    }

    public void setTipoEvento(String type) {
        this.tipoEvento = type;
    }

    public int getNumPartecipanti() {
        return this.numPartecipanti;
    }

    public void setNumPartecipanti(int num) {
        this.numPartecipanti = num;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}