package androidcomponents.piin.com.androidcomponents.ListView

/**
 * Created by jairpinedo on 23/08/17.
 */
class Model (image: Int, name: String, description: String) {

    private var image = image

    private var name = name

    private var description = description

    fun getImage(): Int {
        return this.image
    }

    fun getName(): String {
        return this.name
    }

    fun getDescription(): String{
        return this.description
    }

}