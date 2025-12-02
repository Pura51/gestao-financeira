package com.gestao.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Entidade JPA quee representa um movimento financeiro (ganho ou gasto).
 * Cada instância mapeia para uma linha da tabla "movimentos".
 */
@Entity
@Table(name = "movimentos")
public class Movimento {

    // Chave primária: UUID gerado automaticamente
    @Id
    @GeneratedValue
    private UUID id;

    // Tipo: "ganho" ou "gasto" - campo obrigatório na BD
    @Column(nullable = false)
    private String tipo;

    // Valor do movimento (ex: 12.50)
    @Column(nullable = false)
    private Double valor;

    // Categoria (ex: "Alimentação", "Salário") - opcional
    private String categoria;

    // Descrição livre
    private String descricao;

    // Data do movimento (apenas data sem hora) - obrigatório
    @Column(nullable = false)
    private LocalDate data;

    // Data de criação do registo com timestamp
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    // Construtor vazio requerido pelo JPA
    public Movimento() {}

    // Getters / Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
