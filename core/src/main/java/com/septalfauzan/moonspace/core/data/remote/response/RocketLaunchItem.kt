package com.septalfauzan.moonspace.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class RocketLaunchItem(

	@field:SerializedName("infographic")
	val infographic: Any? = null,

	@field:SerializedName("r_spacex_api_id")
	val rSpacexApiId: Any? = null,

	@field:SerializedName("location_launch_attempt_count")
	val locationLaunchAttemptCount: Int? = null,

	@field:SerializedName("pad_turnaround")
	val padTurnaround: String? = null,

	@field:SerializedName("window_end")
	val windowEnd: String? = null,

	@field:SerializedName("rocket")
	val rocket: Rocket? = null,

	@field:SerializedName("launch_service_provider")
	val launchServiceProvider: LaunchServiceProvider? = null,

	@field:SerializedName("program")
	val program: List<Any?>? = null,

	@field:SerializedName("updates")
	val updates: List<UpdatesItem?>? = null,

	@field:SerializedName("failreason")
	val failreason: String? = null,

	@field:SerializedName("pad")
	val pad: Pad? = null,

	@field:SerializedName("agency_launch_attempt_count")
	val agencyLaunchAttemptCount: Int? = null,

	@field:SerializedName("webcast_live")
	val webcastLive: Boolean? = null,

	@field:SerializedName("flightclub_url")
	val flightclubUrl: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("orbital_launch_attempt_count")
	val orbitalLaunchAttemptCount: Int? = null,

	@field:SerializedName("net")
	val net: String? = null,

	@field:SerializedName("location_launch_attempt_count_year")
	val locationLaunchAttemptCountYear: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("hashtag")
	val hashtag: Any? = null,

	@field:SerializedName("vidURLs")
	val vidURLs: List<VidURLsItem?>? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("last_updated")
	val lastUpdated: String? = null,

	@field:SerializedName("net_precision")
	val netPrecision: NetPrecision? = null,

	@field:SerializedName("probability")
	val probability: Int? = null,

	@field:SerializedName("orbital_launch_attempt_count_year")
	val orbitalLaunchAttemptCountYear: Int? = null,

	@field:SerializedName("window_start")
	val windowStart: String? = null,

	@field:SerializedName("infoURLs")
	val infoURLs: List<InfoURLsItem?>? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("agency_launch_attempt_count_year")
	val agencyLaunchAttemptCountYear: Int? = null,

	@field:SerializedName("mission")
	val mission: Mission? = null,

	@field:SerializedName("pad_launch_attempt_count")
	val padLaunchAttemptCount: Int? = null,

	@field:SerializedName("holdreason")
	val holdreason: String? = null,

	@field:SerializedName("pad_launch_attempt_count_year")
	val padLaunchAttemptCountYear: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("weather_concerns")
	val weatherConcerns: String? = null,

	@field:SerializedName("mission_patches")
	val missionPatches: List<MissionPatchesItem?>? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

data class Orbit(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("abbrev")
	val abbrev: String? = null
)

data class AgenciesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("featured")
	val featured: Boolean? = null,

	@field:SerializedName("wiki_url")
	val wikiUrl: String? = null,

	@field:SerializedName("logo_url")
	val logoUrl: String? = null,

	@field:SerializedName("pending_launches")
	val pendingLaunches: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("successful_launches")
	val successfulLaunches: Int? = null,

	@field:SerializedName("launchers")
	val launchers: String? = null,

	@field:SerializedName("spacecraft")
	val spacecraft: String? = null,

	@field:SerializedName("administrator")
	val administrator: String? = null,

	@field:SerializedName("failed_landings")
	val failedLandings: Int? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("launch_library_url")
	val launchLibraryUrl: String? = null,

	@field:SerializedName("consecutive_successful_landings")
	val consecutiveSuccessfulLandings: Int? = null,

	@field:SerializedName("consecutive_successful_launches")
	val consecutiveSuccessfulLaunches: Int? = null,

	@field:SerializedName("successful_landings")
	val successfulLandings: Int? = null,

	@field:SerializedName("nation_url")
	val nationUrl: String? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("attempted_landings")
	val attemptedLandings: Int? = null,

	@field:SerializedName("founding_year")
	val foundingYear: String? = null,

	@field:SerializedName("failed_launches")
	val failedLaunches: Int? = null,

	@field:SerializedName("abbrev")
	val abbrev: String? = null,

	@field:SerializedName("total_launch_count")
	val totalLaunchCount: Int? = null,

	@field:SerializedName("info_url")
	val infoUrl: String? = null
)

data class Pad(

	@field:SerializedName("wiki_url")
	val wikiUrl: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("agency_id")
	val agencyId: Int? = null,

	@field:SerializedName("map_url")
	val mapUrl: String? = null,

	@field:SerializedName("description")
	val description: Any? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("orbital_launch_attempt_count")
	val orbitalLaunchAttemptCount: Int? = null,

	@field:SerializedName("info_url")
	val infoUrl: Any? = null,

	@field:SerializedName("map_image")
	val mapImage: String? = null,

	@field:SerializedName("total_launch_count")
	val totalLaunchCount: Int? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)

data class LaunchServiceProvider(

	@field:SerializedName("featured")
	val featured: Boolean? = null,

	@field:SerializedName("wiki_url")
	val wikiUrl: String? = null,

	@field:SerializedName("logo_url")
	val logoUrl: String? = null,

	@field:SerializedName("pending_launches")
	val pendingLaunches: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("successful_launches")
	val successfulLaunches: Int? = null,

	@field:SerializedName("launchers")
	val launchers: String? = null,

	@field:SerializedName("spacecraft")
	val spacecraft: String? = null,

	@field:SerializedName("administrator")
	val administrator: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("failed_landings")
	val failedLandings: Int? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("launch_library_url")
	val launchLibraryUrl: String? = null,

	@field:SerializedName("consecutive_successful_landings")
	val consecutiveSuccessfulLandings: Int? = null,

	@field:SerializedName("consecutive_successful_launches")
	val consecutiveSuccessfulLaunches: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("successful_landings")
	val successfulLandings: Int? = null,

	@field:SerializedName("nation_url")
	val nationUrl: String? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("attempted_landings")
	val attemptedLandings: Int? = null,

	@field:SerializedName("founding_year")
	val foundingYear: String? = null,

	@field:SerializedName("failed_launches")
	val failedLaunches: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("abbrev")
	val abbrev: String? = null,

	@field:SerializedName("total_launch_count")
	val totalLaunchCount: Int? = null,

	@field:SerializedName("info_url")
	val infoUrl: String? = null
)

data class Agency(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Configuration(

	@field:SerializedName("min_stage")
	val minStage: Int? = null,

	@field:SerializedName("apogee")
	val apogee: Int? = null,

	@field:SerializedName("launch_mass")
	val launchMass: Int? = null,

	@field:SerializedName("wiki_url")
	val wikiUrl: String? = null,

	@field:SerializedName("pending_launches")
	val pendingLaunches: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("program")
	val program: List<ProgramItem?>? = null,

	@field:SerializedName("successful_launches")
	val successfulLaunches: Int? = null,

	@field:SerializedName("maiden_flight")
	val maidenFlight: String? = null,

	@field:SerializedName("manufacturer")
	val manufacturer: Manufacturer? = null,

	@field:SerializedName("diameter")
	val diameter: Any? = null,

	@field:SerializedName("variant")
	val variant: String? = null,

	@field:SerializedName("launch_cost")
	val launchCost: String? = null,

	@field:SerializedName("alias")
	val alias: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("leo_capacity")
	val leoCapacity: Int? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("failed_landings")
	val failedLandings: Int? = null,

	@field:SerializedName("length")
	val length: Any? = null,

	@field:SerializedName("active")
	val active: Boolean? = null,

	@field:SerializedName("to_thrust")
	val toThrust: Int? = null,

	@field:SerializedName("max_stage")
	val maxStage: Int? = null,

	@field:SerializedName("consecutive_successful_landings")
	val consecutiveSuccessfulLandings: Int? = null,

	@field:SerializedName("consecutive_successful_launches")
	val consecutiveSuccessfulLaunches: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("successful_landings")
	val successfulLandings: Int? = null,

	@field:SerializedName("reusable")
	val reusable: Boolean? = null,

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("attempted_landings")
	val attemptedLandings: Int? = null,

	@field:SerializedName("vehicle_range")
	val vehicleRange: Any? = null,

	@field:SerializedName("failed_launches")
	val failedLaunches: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("gto_capacity")
	val gtoCapacity: Int? = null,

	@field:SerializedName("family")
	val family: String? = null,

	@field:SerializedName("info_url")
	val infoUrl: String? = null,

	@field:SerializedName("total_launch_count")
	val totalLaunchCount: Int? = null
)

data class UpdatesItem(

	@field:SerializedName("profile_image")
	val profileImage: String? = null,

	@field:SerializedName("created_on")
	val createdOn: String? = null,

	@field:SerializedName("comment")
	val comment: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("created_by")
	val createdBy: String? = null,

	@field:SerializedName("info_url")
	val infoUrl: String? = null
)

data class Status(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("abbrev")
	val abbrev: String? = null
)

data class LauncherStageItem(

	@field:SerializedName("turn_around_time_days")
	val turnAroundTimeDays: Int? = null,

	@field:SerializedName("previous_flight")
	val previousFlight: PreviousFlight? = null,

	@field:SerializedName("landing")
	val landing: Landing? = null,

	@field:SerializedName("previous_flight_date")
	val previousFlightDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("reused")
	val reused: Boolean? = null,

	@field:SerializedName("launcher_flight_number")
	val launcherFlightNumber: Int? = null,

	@field:SerializedName("launcher")
	val launcher: Launcher? = null
)

data class InfoURLsItem(

	@field:SerializedName("feature_image")
	val featureImage: Any? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: Language? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("priority")
	val priority: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: Type? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Mission(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("agencies")
	val agencies: List<AgenciesItem?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("orbit")
	val orbit: Orbit? = null,

	@field:SerializedName("launch_designator")
	val launchDesignator: Any? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("info_urls")
	val infoUrls: List<Any?>? = null,

	@field:SerializedName("vid_urls")
	val vidUrls: List<Any?>? = null
)

data class NetPrecision(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("abbrev")
	val abbrev: String? = null
)

data class PreviousFlight(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class Landing(

	@field:SerializedName("downrange_distance")
	val downrangeDistance: Any? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: Type? = null,

	@field:SerializedName("attempt")
	val attempt: Boolean? = null
)

data class ProgramItem(

	@field:SerializedName("end_date")
	val endDate: Any? = null,

	@field:SerializedName("wiki_url")
	val wikiUrl: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mission_patches")
	val missionPatches: List<Any?>? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("agencies")
	val agencies: List<AgenciesItem?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("info_url")
	val infoUrl: Any? = null,

	@field:SerializedName("start_date")
	val startDate: String? = null
)

data class Launcher(

	@field:SerializedName("attempted_landings")
	val attemptedLandings: Int? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("details")
	val details: String? = null,

	@field:SerializedName("serial_number")
	val serialNumber: String? = null,

	@field:SerializedName("last_launch_date")
	val lastLaunchDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("flights")
	val flights: Int? = null,

	@field:SerializedName("first_launch_date")
	val firstLaunchDate: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("flight_proven")
	val flightProven: Boolean? = null,

	@field:SerializedName("successful_landings")
	val successfulLandings: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Rocket(

	@field:SerializedName("configuration")
	val configuration: Configuration? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("launcher_stage")
	val launcherStage: List<LauncherStageItem?>? = null,

	@field:SerializedName("spacecraft_stage")
	val spacecraftStage: Any? = null
)

data class Language(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Manufacturer(

	@field:SerializedName("featured")
	val featured: Boolean? = null,

	@field:SerializedName("wiki_url")
	val wikiUrl: String? = null,

	@field:SerializedName("logo_url")
	val logoUrl: String? = null,

	@field:SerializedName("pending_launches")
	val pendingLaunches: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("successful_launches")
	val successfulLaunches: Int? = null,

	@field:SerializedName("launchers")
	val launchers: String? = null,

	@field:SerializedName("spacecraft")
	val spacecraft: String? = null,

	@field:SerializedName("administrator")
	val administrator: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("failed_landings")
	val failedLandings: Int? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("launch_library_url")
	val launchLibraryUrl: String? = null,

	@field:SerializedName("consecutive_successful_landings")
	val consecutiveSuccessfulLandings: Int? = null,

	@field:SerializedName("consecutive_successful_launches")
	val consecutiveSuccessfulLaunches: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("successful_landings")
	val successfulLandings: Int? = null,

	@field:SerializedName("nation_url")
	val nationUrl: String? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("attempted_landings")
	val attemptedLandings: Int? = null,

	@field:SerializedName("founding_year")
	val foundingYear: String? = null,

	@field:SerializedName("failed_launches")
	val failedLaunches: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("abbrev")
	val abbrev: String? = null,

	@field:SerializedName("total_launch_count")
	val totalLaunchCount: Int? = null,

	@field:SerializedName("info_url")
	val infoUrl: String? = null
)

data class Type(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("abbrev")
	val abbrev: String? = null
)

data class VidURLsItem(

	@field:SerializedName("feature_image")
	val featureImage: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: Language? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("priority")
	val priority: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: Type? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Location(

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("timezone_name")
	val timezoneName: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("total_landing_count")
	val totalLandingCount: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("map_image")
	val mapImage: String? = null,

	@field:SerializedName("total_launch_count")
	val totalLaunchCount: Int? = null,

	@field:SerializedName("location")
	val location: Any? = null,

	@field:SerializedName("abbrev")
	val abbrev: String? = null,

	@field:SerializedName("successful_landings")
	val successfulLandings: Int? = null
)

data class MissionPatchesItem(

	@field:SerializedName("agency")
	val agency: Agency? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("priority")
	val priority: Int? = null
)
