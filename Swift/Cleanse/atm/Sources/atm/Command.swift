//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

protocol Command {
    
    var key: String { get }
    
    func handle(input: [String]) -> Status

}

enum Status {
    case invalid
    case handled
}
