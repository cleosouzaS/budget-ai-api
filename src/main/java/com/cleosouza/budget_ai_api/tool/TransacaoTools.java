package com.cleosouza.budget_ai_api.tool;

import com.cleosouza.budget_ai_api.entity.Transacao;
import com.cleosouza.budget_ai_api.enums.TipoTransacao;
import com.cleosouza.budget_ai_api.repository.TransacaoRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransacaoTools {

    private final TransacaoRepository repository;

    public TransacaoTools(TransacaoRepository repository) {
        this.repository = repository;
    }

    @Tool(description = "Cadastra uma nova transação financeira. Use para registrar receitas ou despesas.")
    public String cadastrarTransacao(
            String descricao,
            BigDecimal valor,
            TipoTransacao tipo) {

        Transacao transacao = new Transacao(
                descricao,
                valor,
                tipo
        );

        Transacao salva = repository.save(transacao);

        return "Transação cadastrada com sucesso. ID: " + salva.getId()
                + ", descrição: " + salva.getDescricao()
                + ", valor: " + salva.getValor()
                + ", tipo: " + salva.getTipo();
    }
    @Tool(description = "Consulta todas as transações financeiras cadastradas no sistema.")
public String consultarTransacoes() {

    var transacoes = repository.findAll();

    if (transacoes.isEmpty()) {
        return "Não existem transações cadastradas.";
    }

    StringBuilder resultado = new StringBuilder();

    for (Transacao transacao : transacoes) {
        resultado.append("ID: ")
                .append(transacao.getId())
                .append(" | Descrição: ")
                .append(transacao.getDescricao())
                .append(" | Valor: R$ ")
                .append(transacao.getValor())
                .append(" | Tipo: ")
                .append(transacao.getTipo())
                .append("\n");
    }

    return resultado.toString();
 }

   @Tool(description = "Calcula o total de todas as despesas financeiras cadastradas.")
public String consultarGastos() {

    var transacoes = repository.findAll();

    BigDecimal total = BigDecimal.ZERO;

    for (Transacao transacao : transacoes) {
        if (transacao.getTipo() == TipoTransacao.DESPESA) {
            total = total.add(transacao.getValor());
        }
    }

    return "Total de despesas: R$ " + total;
 }
  @Tool(description = "Calcula o saldo financeiro atual, subtraindo o total de despesas do total de receitas.")
public String consultarSaldo() {

    var transacoes = repository.findAll();

    BigDecimal receitas = BigDecimal.ZERO;
    BigDecimal despesas = BigDecimal.ZERO;

    for (Transacao transacao : transacoes) {

        if (transacao.getTipo() == TipoTransacao.RECEITA) {
            receitas = receitas.add(transacao.getValor());
        }

        if (transacao.getTipo() == TipoTransacao.DESPESA) {
            despesas = despesas.add(transacao.getValor());
        }
    }

    BigDecimal saldo = receitas.subtract(despesas);

    return "Saldo atual: R$ " + saldo
            + " | Receitas: R$ " + receitas
            + " | Despesas: R$ " + despesas;
}
}

