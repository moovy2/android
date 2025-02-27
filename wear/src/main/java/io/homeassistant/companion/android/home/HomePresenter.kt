package io.homeassistant.companion.android.home

import io.homeassistant.companion.android.common.data.integration.Entity
import io.homeassistant.companion.android.data.SimplifiedEntity
import kotlinx.coroutines.flow.Flow

interface HomePresenter {

    fun init(homeView: HomeView)

    fun onViewReady()
    suspend fun onEntityClicked(entityId: String, state: String)
    fun onLogoutClicked()
    fun onFinish()

    suspend fun isConnected(): Boolean

    suspend fun getEntities(): List<Entity<*>>?
    suspend fun getEntityUpdates(): Flow<Entity<*>>?
    suspend fun getTileShortcuts(): List<SimplifiedEntity>
    suspend fun setTileShortcuts(entities: List<SimplifiedEntity>)

    suspend fun getWearHapticFeedback(): Boolean
    suspend fun setWearHapticFeedback(enabled: Boolean)
    suspend fun getWearToastConfirmation(): Boolean
    suspend fun setWearToastConfirmation(enabled: Boolean)
}
