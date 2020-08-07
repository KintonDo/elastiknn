package com.klibisz.elastiknn.models

import com.klibisz.elastiknn.api.{Mapping, Vec}

trait HashingFunction[M <: Mapping, V <: Vec] extends (V => Array[HashAndFreq]) {
  val mapping: M
}
