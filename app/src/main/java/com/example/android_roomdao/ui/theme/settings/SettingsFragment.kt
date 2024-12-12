// Dans SettingsFragment.kt
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import android.os.Bundle
import android.content.SharedPreferences

class SettingsFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onResume() {
        super.onResume()
        // Enregistrer l'écouteur de changements
        preferenceManager.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        // Désenregistrer l'écouteur pour éviter les fuites de mémoire
        preferenceManager.sharedPreferences?.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        // Réagir aux changements spécifiques de préférences
        when (key) {
            "theme_preference" -> {
                // Exemple : Mettre à jour le thème de l'application
                updateAppTheme()
            }
            "notifications_preference" -> {
                // Exemple : Gérer les paramètres de notifications
                handleNotificationSettingsChange()
            }
        }
    }

    private fun updateAppTheme() {
        // Logique pour changer le thème de l'application
    }

    private fun handleNotificationSettingsChange() {
        // Logique pour gérer les paramètres de notifications
    }
}