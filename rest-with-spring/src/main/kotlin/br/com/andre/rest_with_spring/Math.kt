package br.com.andre.rest_with_spring

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Math {

    @RequestMapping(value = ["/sum/{NumberOne}/{NumberTwo}"])
    fun sum(@PathVariable(value="NumberOne") NumberOne: String,
            @PathVariable(value="NumberTwo") NumberTwo: String):Double {
        if (!enumero(NumberOne) || !enumero(NumberTwo)) {
            throw Exception()
        }

        return convertToDouble(NumberOne) + convertToDouble(NumberTwo)
    }


    private fun convertToDouble(numero: String): Double {

            var numero = numero.replace(',', '.')
            return if (enumero(numero)) numero.toDouble() else 0.0
    }



    private fun enumero(numero: String?):Boolean {
        if (numero.isNullOrBlank()){
            return false
        } else {
            return true
        }
    }

}
