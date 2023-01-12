enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    /*
    Cria conteúdos educacionais
    - As listas com conteúdos educacionais podem ser criadas dentro da formação, porém decidi criá-las de forma separada para organizar o código */
    val kotlin = mutableListOf(ConteudoEducacional("Curso Kotlin", 20))
    val javaScript = mutableListOf(ConteudoEducacional("Curso JavaScript", 30))
    val python = mutableListOf(ConteudoEducacional("Curso Python", 60))

    // Cria formações
    val kotlinExperience = Formacao("Kotlin Experience", kotlin, Nivel.AVANCADO)
    val javaScriptExperience = Formacao("JavaScript Experience", javaScript, Nivel.BASICO)
    val pythonExperience = Formacao("Python Experience", python, Nivel.INTERMEDIARIO)

    // Cria usuários
    val user1 = Usuario("Paulo Daniel")
    val user2 = Usuario("Daniel Nascimento")
    val user3 = Usuario("Paulo Rodrigues")
    val user4 = Usuario("Paulo Nascimento")

    // Adiciona usuários na formação Kotlin Experience
    kotlinExperience.matricular(user1)
    kotlinExperience.matricular(user2)

    // Adiciona usuários na formação JavaScript Experience
    javaScriptExperience.matricular(user1)
    javaScriptExperience.matricular(user3)

    // Adiciona usuários na formação Python Experience
    pythonExperience.matricular(user2)
    pythonExperience.matricular(user4)

    // Mostra lista de usuários nas formações
    println("Usuários inscritos em Kotlin Experience:\n${kotlinExperience.inscritos}")
    println("------------------------------\n")

    println("Usuários inscritos em JavaScript Experience:\n${javaScriptExperience.inscritos}")
    println("------------------------------\n")

    println("Usuários inscritos em Python Experience:\n${pythonExperience.inscritos}")
    println("------------------------------\n")
}


