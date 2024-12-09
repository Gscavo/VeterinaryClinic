/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.gscavo.veterinaryclinic.utils.enums;

import lombok.AllArgsConstructor;

/**
 *
 * @author gscavo
 */

@AllArgsConstructor
public enum AppointmentStatus {
    NOT_REALIZED(),
    CANCELED(),
    DIDNT_SHOW(),
    REALIZED(),
}
