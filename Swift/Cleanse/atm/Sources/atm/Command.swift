//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

protocol Command {
    
    var key: String { get }
    
    func handleInput(input: [String]) -> Status

}

enum Status {
    case invalid
    case handled
}
