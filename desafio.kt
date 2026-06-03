enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuario matriculado em: $nome")
    }
}

fun main() {
    val mobile = ConteudoEducacional("Desenvolvimento Mobile", 120)
    val frontend = ConteudoEducacional("Desenvolvimento Frontend", 90)
    val backend = ConteudoEducacional("Desenvolvimento Backend", 100)
    val fullstack = ConteudoEducacional("Desenvolvimento Fullstack", 150)

    val formacao = Formacao(
        nome = "Formacao Kotlin",
        conteudos = listOf(mobile, frontend, backend, fullstack)
    )

    println("Conteudos da ${formacao.nome}:")
    formacao.conteudos.forEach { println("- ${it.nome} (${it.duracao} min)") }

    val usuario1 = Usuario()
    val usuario2 = Usuario()
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("Total de inscritos: ${formacao.inscritos.size}")
}
