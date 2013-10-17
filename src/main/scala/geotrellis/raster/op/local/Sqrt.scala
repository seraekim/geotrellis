package geotrellis.raster.op.local

import geotrellis._
import geotrellis.process._

/**
 * Operation for taking a square root.
 */
object Sqrt {
  /** Take the square root each value in a raster. */
  def apply(r:Op[Raster]) = 
    r.map(_.dualMap(z => if(z == NODATA || z < 0) NODATA else math.sqrt(z).toInt)
                   (math.sqrt(_)))
     .withName("Sqrt[Raster]")
}
