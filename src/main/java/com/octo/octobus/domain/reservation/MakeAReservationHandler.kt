import com.octo.octobus.domain.core.command.CommandResponse
import com.octo.octobus.domain.reservation.BusRepository
import com.octo.octobus.domain.reservation.CouponRepository

class MakeAReservationHandler(
    private val couponRepository: CouponRepository,
    private val busRepository: BusRepository
) {
    fun handle(command: MakeAReservation): CommandResponse {
        val bus = busRepository.get()
        val coupons = bus.reserve(command.numberOfSeats)

        couponRepository.save(coupons)
        busRepository.save(bus)

        return CommandResponse()
    }
}

class MakeAReservation(val numberOfSeats: Int)