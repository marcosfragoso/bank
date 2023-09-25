package com.bank.config;

import com.bank.domain.deposito.Deposito;
import com.bank.domain.saque.Saque;
import com.bank.domain.transacao.Transacao;
import com.bank.domain.usuario.TipoUsuario;
import com.bank.domain.usuario.Usuario;
import com.bank.repositories.DepositoRepository;
import com.bank.repositories.SaqueRepository;
import com.bank.repositories.TransacaoRepository;
import com.bank.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Classe de configuração apenas para popular a base de dados ao iniciar a API.
 * Essa base de dados não seguiu nenhuma operação/regra de negócio do sistema, foi feito apenas para popular a base de dados.
 *
 */
@Configuration
@Profile("test")
public class DataInitializer implements CommandLineRunner {
    /**
     * Anotation @Autowired injeta as dependências em seu repositorio com acesso ao usuarioRepository.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Anotation @Autowired injeta as dependências em seu repositorio com acesso ao depositoRepository.
     */
    @Autowired
    private DepositoRepository depositoRepository;

    /**
     * Anotation @Autowired injeta as dependências em seu repositorio com acesso ao transacaoRepository.
     */
    @Autowired
    private TransacaoRepository transacaoRepository;

    /**
     * Anotation @Autowired injeta as dependências em seu repositorio com acesso ao saqueRepository.
     */
    @Autowired
    private SaqueRepository saqueRepository;

    @Override
    public void run(String... args) throws Exception {

        // Populando os usuários
        Usuario u1 = new Usuario(null, "João da Silva", "Fragoso", "1234567891", "joaozinho@gmail.com", "minhasenha", new BigDecimal(500), TipoUsuario.NORMAL);
        Usuario u2 = new Usuario(null, "Maria Oliveira", "Santos", "9876543210", "maria@gmail.com", "senhadificil", new BigDecimal(1000), TipoUsuario.COMERCIANTE);
        Usuario u3 = new Usuario(null, "Pedro Souza", "Silva", "1188111111", "pedro@gmail.com", "123456", new BigDecimal(250), TipoUsuario.NORMAL);
        Usuario u4 = new Usuario(null, "Ana Lima", "Pereira", "5555559055", "ana@gmail.com", "senha123", new BigDecimal(800), TipoUsuario.NORMAL);
        Usuario u5 = new Usuario(null, "Lucas Gomes", "Sousa", "2222322222", "lucas@gmail.com", "lucaspass", new BigDecimal(350), TipoUsuario.NORMAL);
        Usuario u6 = new Usuario(null, "Laura Oliveira", "Cruz", "3333333333", "laura@gmail.com", "laurapass", new BigDecimal(700), TipoUsuario.NORMAL);
        Usuario u7 = new Usuario(null, "Carlos Alves", "Silveira", "4444444444", "carlos@gmail.com", "carlospwd", new BigDecimal(150), TipoUsuario.NORMAL);
        Usuario u8 = new Usuario(null, "Mariana Ferreira", "Lima", "8888888888", "mariana@gmail.com", "marianapass", new BigDecimal(200), TipoUsuario.NORMAL);
        Usuario u9 = new Usuario(null, "Felipe Santos", "Rocha", "6666666666", "felipe@gmail.com", "felipe123", new BigDecimal(400), TipoUsuario.NORMAL);
        Usuario u10 = new Usuario(null, "Camila Pereira", "Santana", "7777777777", "camila@gmail.com", "camilapass", new BigDecimal(1200), TipoUsuario.COMERCIANTE);
        Usuario u11 = new Usuario(null, "Gabriela Lima", "Carvalho", "9999999999", "gabriela@gmail.com", "gabrielapass", new BigDecimal(180), TipoUsuario.NORMAL);
        Usuario u12 = new Usuario(null, "Rafael Silva", "Mendes", "7777457777", "rafael@gmail.com", "rafaelpass", new BigDecimal(750), TipoUsuario.NORMAL);
        Usuario u13 = new Usuario(null, "Juliana Ferreira", "Oliveira", "6666688666", "juliana@gmail.com", "juliana123", new BigDecimal(300), TipoUsuario.NORMAL);
        Usuario u14 = new Usuario(null, "Luiz Sousa", "Gomes", "2222226222", "luiz@gmail.com", "luizpass", new BigDecimal(450), TipoUsuario.NORMAL);
        Usuario u15 = new Usuario(null, "Fernanda Lima", "Santana", "3373333333", "fernanda@gmail.com", "fernandapass", new BigDecimal(1100), TipoUsuario.COMERCIANTE);
        Usuario u16 = new Usuario(null, "Gustavo Alves", "Rocha", "5555555555", "gustavo@gmail.com", "gustavopass", new BigDecimal(550), TipoUsuario.NORMAL);
        Usuario u17 = new Usuario(null, "Marcela Santos", "Pereira", "1111199111", "marcela@gmail.com", "marcelapass", new BigDecimal(900), TipoUsuario.COMERCIANTE);
        Usuario u18 = new Usuario(null, "Rodrigo Silva", "Oliveira", "8888008888", "rodrigo@gmail.com", "rodrigopass", new BigDecimal(700), TipoUsuario.NORMAL);
        Usuario u19 = new Usuario(null, "Carolina Lima", "Ferreira", "9911999999", "carolina@gmail.com", "carolinapass", new BigDecimal(250), TipoUsuario.NORMAL);
        Usuario u20 = new Usuario(null, "Mariana Gomes", "Sousa", "4444114444", "mariana2@gmail.com", "marianapass", new BigDecimal(600), TipoUsuario.NORMAL);
        this.usuarioRepository.saveAll(Arrays.asList(
                u1, u2, u3, u4, u5, u6, u7, u8, u9, u10,
                u11, u12, u13, u14, u15, u16, u17, u18, u19, u20
        ));

        // Populando as transações
        Transacao t1 = new Transacao(null, new BigDecimal(300), u2, u1, LocalDateTime.now());
        Transacao t2 = new Transacao(null, new BigDecimal(150), u2, u3, LocalDateTime.now());
        Transacao t3 = new Transacao(null, new BigDecimal(200), u3, u4, LocalDateTime.now());
        Transacao t4 = new Transacao(null, new BigDecimal(100), u4, u5, LocalDateTime.now());
        Transacao t5 = new Transacao(null, new BigDecimal(250), u5, u6, LocalDateTime.now());
        Transacao t6 = new Transacao(null, new BigDecimal(50), u6, u7, LocalDateTime.now());
        Transacao t7 = new Transacao(null, new BigDecimal(180), u7, u8, LocalDateTime.now());
        Transacao t8 = new Transacao(null, new BigDecimal(120), u8, u9, LocalDateTime.now());
        Transacao t9 = new Transacao(null, new BigDecimal(400), u9, u10, LocalDateTime.now());
        Transacao t10 = new Transacao(null, new BigDecimal(350), u10, u11, LocalDateTime.now());
        this.transacaoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));

        // Populando os saques
        Saque s1 = new Saque(null, u1, new BigDecimal(200), LocalDateTime.now());
        Saque s2 = new Saque(null, u2, new BigDecimal(100), LocalDateTime.now());
        Saque s3 = new Saque(null, u3, new BigDecimal(50), LocalDateTime.now());
        Saque s4 = new Saque(null, u4, new BigDecimal(150), LocalDateTime.now());
        Saque s5 = new Saque(null, u5, new BigDecimal(75), LocalDateTime.now());
        Saque s6 = new Saque(null, u6, new BigDecimal(25), LocalDateTime.now());
        Saque s7 = new Saque(null, u7, new BigDecimal(90), LocalDateTime.now());
        Saque s8 = new Saque(null, u8, new BigDecimal(30), LocalDateTime.now());
        Saque s9 = new Saque(null, u9, new BigDecimal(80), LocalDateTime.now());
        Saque s10 = new Saque(null, u10, new BigDecimal(60), LocalDateTime.now());
        this.saqueRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10));

        // Populando os depósitos
        Deposito d1 = new Deposito(null, u1, new BigDecimal(300), LocalDateTime.now());
        Deposito d2 = new Deposito(null, u2, new BigDecimal(150), LocalDateTime.now());
        Deposito d3 = new Deposito(null, u3, new BigDecimal(200), LocalDateTime.now());
        Deposito d4 = new Deposito(null, u4, new BigDecimal(100), LocalDateTime.now());
        Deposito d5 = new Deposito(null, u5, new BigDecimal(250), LocalDateTime.now());
        Deposito d6 = new Deposito(null, u6, new BigDecimal(50), LocalDateTime.now());
        Deposito d7 = new Deposito(null, u7, new BigDecimal(180), LocalDateTime.now());
        Deposito d8 = new Deposito(null, u8, new BigDecimal(120), LocalDateTime.now());
        Deposito d9 = new Deposito(null, u9, new BigDecimal(400), LocalDateTime.now());
        Deposito d10 = new Deposito(null, u10, new BigDecimal(350), LocalDateTime.now());
        this.depositoRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10));
    }
}
