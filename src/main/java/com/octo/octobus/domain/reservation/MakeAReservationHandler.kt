import com.octo.octobus.domain.core.command.CommandResponse
import com.octo.octobus.domain.reservation.Bus
import com.octo.octobus.domain.reservation.Coupon
import com.octo.octobus.infrastructure.repository.Repository

class MakeAReservationHandler(
        private val couponRepository: Repository<List<Coupon>>,
        private val busRepository: Repository<Bus>
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