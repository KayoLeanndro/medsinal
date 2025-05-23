package com.example.medsinal.model;

public class HealthUnit {
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private double latitude;
    private double longitude;
    private String horario;
    private String telefone;

    public HealthUnit() {}

    public HealthUnit(String nome, String endereco, String bairro, String cidade,
                      String estado, double latitude, double longitude,
                      String horario, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.latitude = latitude;
        this.longitude = longitude;
        this.horario = horario;
        this.telefone = telefone;
    }

    // Getters
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getHorario() { return horario; }
    public String getTelefone() { return telefone; }
}
