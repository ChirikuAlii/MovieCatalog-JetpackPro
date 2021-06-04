package id.chirikualii.movie_catalog_android_jetpack_pro.abstraction

/**
 * Created by Chiriku Alii on 6/4/21.
 * github.com/chirikualii
 */

interface BaseMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity
}